import { Component, OnInit } from '@angular/core';
import { HttpClientService, Author, Book } from '../service/httpclient.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book = new Book(null,"",null,null,null,"");
  authors:Author[];

  constructor(
    private httpClientService: HttpClientService,
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

  createBook(): void {
    this.httpClientService.createBook(this.book)
        .subscribe( data => {
          this.router.navigate(['/viewbook']);
          alert("Book created successfully.");
        });
  };

}