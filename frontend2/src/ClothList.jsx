
import React, { useState } from "react";
import BookingForm from "./BookingForm";
import PropTypes from "prop-types";

const ClothList = ({ clothes }) => {
  const [showBookingForm, setShowBookingForm] = useState(false);
  const [selectedClothId, setSelectedClothId] = useState(null);

  const handleBookingClick = (clothId) => {
    setSelectedClothId(clothId);
    setShowBookingForm(true);
  };

  const closeForm = () => {
    setShowBookingForm(false);
    setSelectedClothId(null);
  };

  return (
    <div className="row">
      {clothes.map((cloth) => (
        <div className="col-lg-4 col-md-6 col-sm-12 mb-4" key={cloth.id}>
          <div className="card h-100">
            <img
               src={`http://localhost:8081${cloth.imageUrl}`} 
              className="card-img-top"
              alt={cloth.name}
              onError={(e) => {
                e.target.src = "https://placehold.co/600x400"; // Fallback image
              }}
            />
            <div className="card-body">
              <h5 className="card-title">{cloth.name}</h5>
              <p className="card-text">{cloth.description}</p>
              <p className="card-text">
                <strong>Rent: ₹</strong>
                {cloth.rentPrice}
              </p>
              <p className="card-text">
                Available: {cloth.availability ? "Yes" : "No"}
              </p>
              <button
                onClick={() => handleBookingClick(cloth.id)}
                className="btn btn-primary"
                disabled={!cloth.availability} // Disable if not available
              >
                {cloth.availability ? "Book This Cloth" : "Not Available"}
              </button>
            </div>
          </div>
        </div>
      ))}
      {showBookingForm && (
        <BookingForm clothId={selectedClothId} closeForm={closeForm} />
      )}
    </div>
  );
};

// Prop validation
ClothList.propTypes = {
  clothes: PropTypes.arrayOf(
    PropTypes.shape({
      id: PropTypes.number.isRequired,
      name: PropTypes.string.isRequired,
      description: PropTypes.string.isRequired,
      rentPrice: PropTypes.number.isRequired,
      imageUrl: PropTypes.string,
      availability: PropTypes.bool.isRequired,
    })
  ).isRequired,
};

export default ClothList;




