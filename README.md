This an SpringBoot application in which, we've used REST endpoints for hotel booking.
Users can book hotel, update, view and also cancel their bookings.

Requirements:
Java : 17+
SpringBoot : 3.2+
Build Tool: Maven

H2 In memory database is used.

Default port of Spring is used : http://localhost:8080/

All the documentation of endpoints can be seen in Swagger UI: http://localhost:8080/swagger-ui/index.html

An example of adding a new Guest and his/her hotel bookings:
Post Request : http://localhost:8080/bookHotel
JSON :
{
    "name": "Tushar",
    "email": "tushar@gmail.com",
    "gender": "male",
    "hotelBookings": [
        {
            "hotelName": "Lemon Tree",
            "city": "Jaipur",
            "checkInDate": "16/05/2024",
            "checkOutDate": "18/05/2024",
            "numPersons": 3,
            "numRooms": 2
        },
        {
            "hotelName": "Radisson Blu",
            "city": "Jaipur",
            "checkInDate": "21/08/2024",
            "checkOutDate": "25/08/2024",
            "numPersons": 5,
            "numRooms": 3
        }
    ]
}
