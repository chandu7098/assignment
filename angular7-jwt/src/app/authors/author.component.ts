import { Component, OnInit } from '@angular/core';
import { HttpClientService, Author } from '../service/httpclient.service';
import {Router} from "@angular/router";


@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  authors:Author[];
    
   
  constructor(
    private httpClientService:HttpClientService,
    private router: Router
  ) { }

  ngOnInit() {
     this.httpClientService.getAuthors().subscribe(
      response =>this.handleSuccessfulResponse(response),
     );
  }

handleSuccessfulResponse(response)
{
    this.authors=response;
}

deleteAuthor(author: Author): void {
   this.httpClientService.deleteAuthor(author)
     .subscribe( data => {
      this.authors = this.authors.filter(u => u !== author);
   })
};

}