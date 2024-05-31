use actix_web::{web, App, HttpResponse, HttpServer, Responder};
use serde::{Deserialize, Serialize};

// Define a struct for the JSON response
#[derive(Serialize)]
struct MyResponse {
    message: String,
}

// Define a struct for the JSON request
#[derive(Deserialize)]
struct MyRequest {
    name: String,
}

// Handle for the root endpoint
async fn hello() -> impl Responder {
    HttpResponse::Ok().json(MyResponse {
        message: "Hello, world!".to_string(),
    })
}

// Handler for a POST request
async fn greet(req_body: web::Json<MyRequest>) -> impl Responder {
    let message = format!("Hello, {}!", req_body.name);
    HttpResponse::Ok().json(MyResponse { message })
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    HttpServer::new(|| {
        App::new()
            .route("/", web::get().to(hello))
            .route("/greet", web::post().to(greet))
    })
    .bind("127.0.0.1:8080")?
    .run()
    .await
}
