import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { KeycloakService } from 'src/app/auth/keycloak/keycloak.service';

@Component({
  selector: 'trackwave-navbar',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {

  constructor(private keycloakService: KeycloakService) { }

  async onLogin() {
    await this.keycloakService.login();
  }

  async onLogout() {
    await this.keycloakService.logout();
  }

  async onAccountManagment() {
    await this.keycloakService.accountManagment();
  }
}
