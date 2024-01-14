import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loginUrl = 'http://localhost:8080/login'; // URL to Spring Boot login endpoint

  constructor(private http: HttpClient) { }

  login(username: string, password: string) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/x-www-form-urlencoded' });
    const body = `username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`;

    return this.http.post(this.loginUrl, body, { headers: headers, withCredentials: true, responseType: 'text' });
  }
}