import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { AddAuthorComponent } from './add-author/add-author.component';
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { BasicAuthHtppInterceptorService } from './service/basic-auth-htpp-interceptor.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthorComponent } from 'src/app/authors/author.component';
import { EditAuthorComponent } from 'src/app/edit-author/edit-author.component';
import { AddBookComponent } from 'src/app/add-book/add-book.component';
import { BookComponent } from 'src/app/book/book.component';
import { EditBookComponent } from 'src/app/edit-book/edit-book.component';



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    AddAuthorComponent,
    AuthorComponent,
    EditAuthorComponent,
    AddBookComponent,
    BookComponent,
    EditBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {  
      provide:HTTP_INTERCEPTORS, useClass:BasicAuthHtppInterceptorService, multi:true 
    }
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
