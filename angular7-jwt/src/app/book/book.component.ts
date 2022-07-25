import { Component, OnInit } from '@angular/core';
import { HttpClientService, Author, Book } from '../service/httpclient.service';
import {Router} from "@angular/router";


@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  books:Book[];
    
   
  constructor(
    private httpClientService:HttpClientService,
    private router: Router
  ) { }

  ngOnInit() {
     this.httpClientService.getBooks().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

handleSuccessfulResponse(response)
{
    this.books=response;
}

deleteBook(book: Book): void {
   this.httpClientService.deleteBook(book)
     .subscribe( data => {
      this.books = this.books.filter(u => u !== book);
   })
};

}