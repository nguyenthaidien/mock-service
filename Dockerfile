
FROM node:18

WORKDIR /app

# Install global tools
RUN npm install -g json-server nodemon

# Install dependencies for JWT + JWKS verification
COPY package*.json ./


# Add authentication middleware
RUN npm install jsonwebtoken jwks-rsa
COPY auth-middleware.js ./
COPY db.json ./

EXPOSE 3000
#CMD ["nodemon", "--watch", "db.json", "--watch", "auth-middleware.js", "--exec", "json-server", "--", "--watch", "db.json", "--middlewares", "auth-middleware.js", "--host", "0.0.0.0", "--port", "3000"]
CMD ["nodemon", "--watch", "db.json", "--watch", "auth-middleware.js", "--exec", "json-server", "--", "--watch", "db.json", "--host", "0.0.0.0", "--port", "3000"]