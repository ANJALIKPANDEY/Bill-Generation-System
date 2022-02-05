The complete Billing service is the main service that is used to create a new billing request by giving the name on whom the bill is allotted to, billing due date, bill amount to be paid and tax amount to be paid.
On successful creation of the billing, a bill number is generated and the total amount to be paid including the bill amount and tax is calculated and attached with the bill.
  
The Billing service receives the generated bill number and further updates the Billing entity and sending as the response as the confirmation of the bill with complete bill details.
Also, the user can search any bill by the due date of the bill and the Billing service will respond with the corresponding bill details.
