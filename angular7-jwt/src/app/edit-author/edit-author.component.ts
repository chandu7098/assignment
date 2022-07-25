import { Component, OnInit } from '@angular/core';
import { HttpClientService, Author } from '../service/httpclient.service';
import { ActivatedRoute, Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-author',
  templateUrl: './edit-author.component.html',
  styleUrls: ['./edit-author.component.css']
})
export class EditAuthorComponent implements OnInit {
  author: Author;
  authorId:String;
  

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

    this.httpClientService.getAuthorById(id).subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

handleSuccessfulResponse(response)
{
    this.author=response;
}

editAuthor(): void {
  this.httpClientService.editAuthor(this.author)
      .subscribe( data => {
        this.router.navigate(['']);
        alert("Author updated successfully.");
      });
};

  

}