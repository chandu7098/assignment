import { Component, OnInit } from '@angular/core';
import { HttpClientService, Author } from '../service/httpclient.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-add-author',
  templateUrl: './add-author.component.html',
  styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent implements OnInit {

  author: Author = new Author(null,"","","","",null,"","","","","");

  constructor(
    private httpClientService: HttpClientService,
    private router: Router
  ) { }

  ngOnInit() {
  }

  createAuthor(): void {
    this.httpClientService.createAuthor(this.author)
        .subscribe( data => {
          this.router.navigate(['']);
          alert("Author created successfully.");
        });

  };

}