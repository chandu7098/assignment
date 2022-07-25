import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdService } from './service/auth-gaurd.service';
import { AddAuthorComponent } from 'src/app/add-author/add-author.component';
import { AuthorComponent } from 'src/app/authors/author.component';
import { EditAuthorComponent } from 'src/app/edit-author/edit-author.component';
import { AddBookComponent } from 'src/app/add-book/add-book.component';
import { BookComponent } from 'src/app/book/book.component';
import { EditBookComponent } from 'src/app/edit-book/edit-book.component';


const routes: Routes = [

  { path: 'addauthor', component: AddAuthorComponent,canActivate:[AuthGaurdService]},
  { path: '', component: AuthorComponent,canActivate:[AuthGaurdService] },
  { path: 'editauthor/:id', component: EditAuthorComponent,canActivate:[AuthGaurdService] },

  { path: 'addbook', component: AddBookComponent,canActivate:[AuthGaurdService]},
  { path: 'viewbook', component: BookComponent,canActivate:[AuthGaurdService] },
  { path: 'editbook/:id', component: EditBookComponent,canActivate:[AuthGaurdService] },

  { path: 'login', component: LoginComponent },
  { path: 'logout', component: LogoutComponent,canActivate:[AuthGaurdService] },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
