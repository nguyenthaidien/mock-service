const jsonServer = require('json-server');
const auth = require('json-server-auth');
//const jwt = require('express-jwt');
const { expressjwt: jwt }  = require('express-jwt');
const jwks = require('jwks-rsa');
const express = require('express');

const app = express();

// JWT Middleware for Keycloak
app.use(jwt({
  secret: jwks.expressJwtSecret({
    jwksUri: 'http://10.82.14.80:8080/realms/DCMS-Realm/protocol/openid-connect/certs',
    cache: true,
    rateLimit: true,
    jwksRequestsPerMinute: 5
  }),
  algorithms: ['RS256'],
  issuer: 'http://10.82.14.80:8080/realms/DCMS-Realm',
  // This is the issuer URL of your Keycloak realm
  // Make sure to replace it with your actual Keycloak issuer URL
  // This is optional, you can specify the audience if needed
  audience: 'my-api',
  credentialsRequired: true
}));

// Setup json-server + auth
const router = jsonServer.router('db.json');
app.use(jsonServer.defaults());
app.use(auth);
app.use(router);

app.listen(3000, () => {
  console.log('Mock API server running on port 3000');
});