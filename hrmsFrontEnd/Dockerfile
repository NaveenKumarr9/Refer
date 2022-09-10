	FROM node:latest as builder
	
	RUN mkdir -p /app
	
	WORKDIR /app
	
	COPY . .
	
	RUN npm install
	RUN npm run build --prod
	
	#CMD ["npm", "start"]
	
	FROM nginx:alpine
	#COPY /dist/hrms-front-end /usr/share/nginx/html
	COPY --from=builder /app/dist/hrms-front-end /usr/share/nginx/html