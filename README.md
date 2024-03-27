## Stock Management REST API

This project is a Java-based backend application built using Spring Boot. It provides a RESTful API for managing stocks. The application stores the list of stocks in memory and exposes endpoints to perform CRUD operations on stocks.

### Endpoints

- **GET /api/stocks/all_stock**: 
- **GET /api/stocks/get/{id}**: 
- **PUT /api/stocks/put/{id}**: 
- **POST /api/stocks/create**: 

### Stock Object

The stock object contains the following fields:
- id (Number): Unique identifier for the stock.
- name (String): Name of the stock.
- currentPrice (Amount): Current price of the stock.
- createDate (Timestamp): Timestamp indicating when the stock was created.
- lastUpdate (Timestamp): Timestamp indicating when the stock was last updated.

### Technologies Used

- Java
- Spring Boot

### Getting Started

To run this project locally, follow these steps:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/stock-management-api.git
   ```

2. Navigate to the project directory:

   ```bash
   cd stock-management-api
   ```

3. Build the project:

   ```bash
   ./mvnw clean package
   ```

4. Run the application:

   ```bash
   java -jar target/stock-management-api.jar
   ```

5. Access the API at [http://localhost:8080/api](http://localhost:8080/api)

### Usage

You can use tools like Postman or curl to interact with the API endpoints.

#### Examples:

- **Get all stocks**: Send a GET request to `/api/stocks`.
- **Get a specific stock (ID: 1)**: Send a GET request to `/api/stocks/get/1`.
- **Create a new stock**: Send a POST request to `/api/stocks/create` with a JSON body containing the stock details (e.g., name, current price).
- **Update the price of a stock (ID: 2)**: Send a PUT request to `/api/stocks/put/2` with a JSON body containing the new price.

### Postman Collection

A Postman collection with pre-configured requests is available for testing the API. You can download it [here](https://documenter.getpostman.com/view/32715206/2sA35D74CQ).

### Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

### License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
