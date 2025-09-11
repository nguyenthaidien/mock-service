# Use Node.js base image
FROM node:18


# Install git
RUN apt-get update && apt-get install -y git
# Set working directory
WORKDIR /app

# Calls for a random number to break the cahing of the git clone
# (https://stackoverflow.com/questions/35134713/disable-cache-for-specific-run-commands/58801213#58801213)
ADD "https://www.random.org/cgi-bin/randbyte?nbytes=10&format=h" skipcache

# Clone public GitHub repo
#https://github.com/nguyenthaidien/dcms-config-repo.git
# dcms-config-repo
# This step will re-run if CACHEBUST changes
RUN git clone https://github.com/nguyenthaidien/dcms-config-repo.git
RUN ls -la /app


# Copy package.json and install dependencies
COPY package.json ./
RUN npm install

# Copy your database file and server setup
#COPY /mock/db.json /app/mock/
#COPY /app/dbms-config-repo/db.json /app/mock/
COPY server.js ./

# Expose port for the server
EXPOSE 3000

# Start the server
CMD ["node", "server.js"]