# Billing backend

This repository contains the Spring Boot backend in `billing_application/` and a Render Blueprint at `render.yaml`.

## Deploy to Render with PostgreSQL

1. Push this backend repository to its own Git repository.
2. In Render, create a new Blueprint and connect the backend repository. Render reads `render.yaml` from the repository root; the Blueprint defines the Docker web service and PostgreSQL database.
3. When prompted, set `FRONTEND_URL` to the exact deployed Vercel frontend origin, such as `https://your-frontend.vercel.app` (no path or trailing slash).
4. Deploy. The database connection values are injected into the service from the Render PostgreSQL database; the service listens on Render's `PORT`.
5. Set the frontend's Vercel `VITE_API_BASE_URL` to the deployed backend's public origin, such as `https://billing-backend.onrender.com`, and redeploy the frontend.

The database and service use the free plan in the Blueprint. Check Render's current free-plan limits and database retention/expiration policy before relying on it for persistent production data. Do not commit credentials or put database credentials in frontend environment variables.

## Local development

The app uses PostgreSQL locally by default (`localhost:5432`, database `billing_db`, username/password `postgres`). Override these with `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, and `DB_PASSWORD` environment variables as needed. `FRONTEND_URL` defaults to `http://localhost:5173`.

From `billing_application/`, start the app with:

```sh
./mvnw spring-boot:run
```
