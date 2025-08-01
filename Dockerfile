# Use Node.js base image
FROM node:18

# Set working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package.json ./
RUN npm install

# Copy your database file and server setup
COPY db.json ./
COPY server.js ./

# Expose port for the server
EXPOSE 3000

# Start the server
CMD ["node", "server.js"]