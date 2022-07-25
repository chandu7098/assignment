import { Component, OnInit } from '@angular/core';
import { HttpClientService, Author, Book } from '../service/httpclient.service';
import { ActivatedRoute, Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-book',
  templateUrl: './edit-book.component.html',
  styleUrls: ['./edit-book.component.css']
})
export class EditBookComponent implements OnInit {
  book: Book;
  bookId:String;
  

  // author: Author = new Author(null,"","","","",null,"","","","","");

  constructor(
    private httpClientService: HttpClientService,
    private router: Router,
    private activatedroute:ActivatedRoute
  ) { 
    
  }

  ngOnInit() {
    var id:String;
    this.activatedroute.url.subscribe(url => id = url[1].path);

    this.httpClientService.getBookById(id).subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

handleSuccessfulResponse(response)
{
    this.book=response;
}

editBook(): void {
  this.httpClientService.editBook(this.book)
      .subscribe( data => {
        this.router.navigate(['/viewbook']);
        alert("Author updated successfully.");
      });
};

  

}