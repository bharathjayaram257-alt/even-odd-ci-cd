# Even-Odd Java Maven CI/CD

A small Java application that determines whether an integer is even or odd. JUnit 5 tests run through Maven. GitHub Actions runs the tests/build and, on pushes to `main` or `master`, builds and publishes a Docker image to Docker Hub.

## Project structure

```text
even-odd-ci-cd/
├── .github/workflows/ci-cd.yml
├── src/
│   ├── main/java/com/example/EvenOdd.java
│   └── test/java/com/example/EvenOddTest.java
├── .dockerignore
├── Dockerfile
└── pom.xml
```

## Run locally

Requires JDK 17+ and Maven 3.8+.

```bash
mvn clean verify
```

Run the application (default input is 7):

```bash
java -jar target/even-odd-app-1.0.0.jar
```

Pass a number:

```bash
java -jar target/even-odd-app-1.0.0.jar 12
```

## Configure Docker Hub secrets in GitHub

1. Create a Docker Hub repository named `even-odd-app`.
2. In Docker Hub, create an access token (Account Settings → Personal access tokens).
3. In your GitHub repository, open Settings → Secrets and variables → Actions → New repository secret.
4. Add:
   - `DOCKERHUB_USERNAME` = your Docker Hub username
   - `DOCKERHUB_TOKEN` = the Docker Hub access token (not your account password)

## Push to GitHub

Create an empty GitHub repository named `even-odd-ci-cd`, then from this project folder run:

```bash
git init
git add .
git commit -m "Add Java even-odd Maven project with CI/CD"
git branch -M main
git remote add origin https://github.com/YOUR_GITHUB_USERNAME/even-odd-ci-cd.git
git push -u origin main
```

After the push, open the repository's Actions tab. The workflow runs Maven tests and packages the JAR, then builds and pushes the Docker image. Pull requests run the tests/build but do not publish an image.

## Pull and run the Docker image

Replace `YOUR_DOCKERHUB_USERNAME` with your Docker Hub username:

```bash
docker pull YOUR_DOCKERHUB_USERNAME/even-odd-app:latest
docker run --rm YOUR_DOCKERHUB_USERNAME/even-odd-app:latest 12
```

Expected output:

```text
12 is even.
```
