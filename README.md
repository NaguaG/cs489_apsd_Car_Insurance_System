# cs489_apsd_Car_Insurance_System

Functional Requirements:
1. Get all information of customer, create and calculate specified quote in memory based on the customer information. Then save it into DB table including the information. Send back this quote.
2. If email address will match with previous one, update the quote into DB. Send back quote. 
3. Customer can register as user.
4. Once login into system, required to pay calculated fee of insurance. This method will call external payment service. If payment authorized, send back token for authorize other method.
5. Once authorize, 
   1. can update insurance package (coverage)
   2. can update own information (change vehicle, drivers)
   3. can download as file of proof of insurance

Architectural Plan:
Aim to use Microservice.
1. Customers Service 
2. Quotes Service
3. Coverages Service
