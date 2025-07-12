# 🛒 Food Ordering System (Spring Boot, In-Memory)

A modular **Food Ordering System** built using **Spring Boot** and **Java 17**, simulating real-world restaurant order handling with strategy-based restaurant selection — fully in-memory, no database required.

---

## ✅ Features

* Onboard restaurants with menu, rating, and max order capacity  
* Add/update menu items (no deletion)  
* Place orders using a pluggable strategy:  
  * Lowest Bill Cost  
  * Highest Rated Restaurant  
* Orders assigned only if a single restaurant can fulfill all items  
* Capacity-limited: new orders rejected if max active limit reached  
* Mark accepted orders as completed to free up capacity  
* Fully in-memory using Java collections  

---

## 📦 Package Breakdown

* `constant` – Order status constants  
* `model` – Entity-like classes (`Restaurant`, `Order`, `MenuItem`, `User`)  
* `pojo` – Request & Response DTOs  
* `repository` – In-memory repositories  
* `service` – Business logic layer  
* `utils` – Strategy factory & helper classes  
* `FosApplication` – Main Spring Boot application class  

---

## 🗂️ Project Structure

<pre>
com.fos.fos
├── constant
│   └── AppConstants.java
├── utils
│   └── StrategyFactory.java
├── model
│   ├── Restaurant.java
│   ├── MenuItem.java
│   ├── Order.java
│   └── User.java
├── pojo
│   ├── PlaceOrderRequest.java
│   └── PlaceOrderResponse.java
├── repository
│   ├── RestaurantRepository.java
│   ├── OrderRepository.java
│   └── UserRepository.java
├── service
│   ├── RestaurantService.java
│   ├── OrderService.java
│   ├── SelectionStrategy.java
│   ├── LowestCostStrategy.java
│   ├── HighestRatingStrategy.java
│   └── UserService.java
└── FosApplication.java
</pre>

## 🧪 Sample Output

```bash
Order 1: Order assigned → R3  
Order 2: Order assigned → R2  
Order 3: Order assigned → R2  
Order marked as COMPLETED  
Order 4: Order assigned → R2  
Order 5: Cannot assign the order
```
## 🛠 Technologies Used
* Java 17  
* Spring Boot 3.x  
* Lombok  
* Maven  
* No external database (fully in-memory) 
## 🚀 Getting Started
* Clone the repository
  ```bash
   git clone https://github.com/kumarbablu5598/Food-Ordering-System.git
  
* Navigate to the project directory
  ```bash
     cd Food-Ordering-System
  
* Run the application
  ```bash
   mvn spring-boot:run
* ℹ️ No database setup required — all data is stored in-memory.
  ```
## 📈 Future Enhancements

* Expose RESTful APIs via Spring Web  
* Add wallet/payment support  
* Split orders across multiple restaurants  
* Add unit testing (JUnit/Mockito)  
* Integrate Swagger/OpenAPI documentation
## 📄 License
* This project is licensed under the MIT License.
## 💬 Created by Bablu Kumar

* [🔗 LinkedIn](https://linkedin.com/in/bablu5598)  
* [🌐 Portfolio](https://kumarbablu5598.github.io/portfolio/)


