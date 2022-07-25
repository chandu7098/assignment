import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { StartOfSourceMap } from 'webpack-sources/node_modules/source-map/source-map';

export class Author{
  constructor(
    public authorId:number,
    public firstName:string,
    public lastName:string,
    public email:string,
    public phoneNumber:string,
    public addressId:number,
    public address1:string,
    public address2:string,
    public city:String,
    public state:String,
    public zipcode:String,
  ) {}
}

export class Book{
  constructor(
    public bookId:number,
    public title:string,
    public price:number,
    public numberOfPages:number,
    public authorId:number,
    public authorName:String,
  ) {}
}



@Injectable({
  providedIn: 'root'
})
export class HttpClientService {

  constructor(
    private httpClient:HttpClient
  ) {}

  public getAuthors()
  {
    return this.httpClient.get<Author[]>('http://localhost:9090/author');
  }

  public getBooks()
  {
       return this.httpClient.get<Author[]>('http://localhost:9090/book');
  }

  public deleteAuthor(author) {
    return this.httpClient.delete<Author>("http://localhost:9090/author" + "/"+ author.authorId);
  }

  public deleteBook(book) {
    return this.httpClient.delete<Book>("http://localhost:9090/book" + "/"+ book.bookId);
  }

  public createAuthor(author) {
    return this.httpClient.post<Author>("http://localhost:9090/author", author,);
  }

  public createBook(author) {
    return this.httpClient.post<Author>("http://localhost:9090/book", author);
  }

  public editAuthor(author) {
    return this.httpClient.put<Author>("http://localhost:9090/author", author);
  }

  public editBook(book) {
    let username='javainuse'
    let password='password'
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.put<Author>("http://localhost:9090/book", book,{headers});
  }

  public getAuthorById(authorId) {
    let username='javainuse'
    let password='password'
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<Author>("http://localhost:9090/author" + "/"+ authorId,{headers});
  }

  public getBookById(bookId) {
    let username='javainuse'
    let password='password'
  
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<Book>("http://localhost:9090/book" + "/"+ bookId,{headers});
  }
}