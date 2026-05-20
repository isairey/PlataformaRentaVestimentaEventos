
import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";

const BookingForm = ({ cloth, onClose }) => {
  const [customerName, setCustomerName] = useState("");
  const [customerContact, setCustomerContact] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [totalRent, setTotalRent] = useState(cloth.rentPrice);
  const [bookingSuccess, setBookingSuccess] = useState(false); // New state to track booking success

  const handleSubmit = (e) => {
    e.preventDefault();

    const bookingData = {
      customerName,
      customerContact,
      startDate,
      endDate,
      totalRent,
      cloth: { id: cloth.id },
    };

    fetch("http://localhost:8081/api/bookings", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(bookingData),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log("Booking successful:", data);
        setBookingSuccess(true); // Set success message state to true
        setTimeout(() => {
          setBookingSuccess(false); // Hide success message after 3 seconds
          onClose(); // Close the form
        }, 3000);
      })
      .catch((error) => {
        console.error("Error booking the cloth:", error);
      });
  };

  return (
    <div className="modal show d-block" tabIndex="-1">
      <div className="modal-dialog">
        <div className="modal-content">
          <div className="modal-header">
            <h5 className="modal-title">Book {cloth.name}</h5>
            <button type="button" className="btn-close" onClick={onClose}></button>
          </div>
          <form onSubmit={handleSubmit}>
            <div className="modal-body">
              <div className="mb-3">
                <label className="form-label">Customer Name</label>
                <input
                  type="text"
                  className="form-control"
                  value={customerName}
                  onChange={(e) => setCustomerName(e.target.value)}
                  required
                />
              </div>
              <div className="mb-3">
                <label className="form-label">Customer Contact</label>
                <input
                  type="text"
                  className="form-control"
                  value={customerContact}
                  onChange={(e) => setCustomerContact(e.target.value)}
                  required
                />
              </div>
              <div className="mb-3">
                <label className="form-label">Start Date</label>
                <input
                  type="date"
                  className="form-control"
                  value={startDate}
                  onChange={(e) => setStartDate(e.target.value)}
                  required
                />
              </div>
              <div className="mb-3">
                <label className="form-label">End Date</label>
                <input
                  type="date"
                  className="form-control"
                  value={endDate}
                  onChange={(e) => setEndDate(e.target.value)}
                  required
                />
              </div>
              <div className="mb-3">
                <label className="form-label">Total Rent</label>
                <input
                  type="number"
                  className="form-control"
                  value={totalRent}
                  readOnly
                />
              </div>

              {/* Success Message with Larger Font */}
              {bookingSuccess && (
                <div className="alert alert-success" role="alert" style={{ fontSize: "1.5rem", textAlign: "center", fontWeight: "bold" }}>
                  Booked Successfully!
                </div>
              )}
            </div>
            <div className="modal-footer">
              <button type="submit" className="btn btn-primary">Book Now</button>
              <button type="button" className="btn btn-secondary" onClick={onClose}>Close</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default BookingForm;












