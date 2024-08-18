# Stage 1: Build the Angular app
FROM node:22 AS build
WORKDIR /app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build

# Stage 2 Serve the Angular app with Nginx
FROM nginx:1.27-alpine
COPY nginx.conf.template /etc/nginx/templates/nginx.conf.template
COPY --from=build /app/dist/trackwave/browser /usr/share/nginx/html
