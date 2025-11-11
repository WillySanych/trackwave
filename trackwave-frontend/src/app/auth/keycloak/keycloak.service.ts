import { Injectable } from '@angular/core';
import Keycloak, { KeycloakProfile } from 'keycloak-js';

@Injectable({
  providedIn: 'root'
})
export class KeycloakService {

  private _keycloak: Keycloak | undefined;

  get keycloak(): Keycloak {
    if (!this._keycloak) {
      this._keycloak = new Keycloak({
        url: 'http://localhost:8282',
        realm: 'trackwave',
        clientId: 'test'
      });
    }
    return this._keycloak;
  }

  private _userProfile: KeycloakProfile | undefined;

  get userProfile(): KeycloakProfile | undefined {
    return this._userProfile;
  }

  get token(): String | undefined {
    return this.keycloak.token;
  }

  constructor() { }

  async init() {
    console.log("keycloak init");

    let authenticated = await this.keycloak.init({
    });

    if (authenticated) {
      console.log("user authenticated");
      this._userProfile = await this.keycloak.loadUserProfile();
    } else {
      console.log("user not authenticated");
    }
  }

  login() {
    return this.keycloak.login();
  }

  logout() {
    return this.keycloak.logout({redirectUri: 'http://localhost:4200/'});
  }

  accountManagment() {
    return this.keycloak.accountManagement();
  }
}
