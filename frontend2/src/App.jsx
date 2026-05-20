
// import React, { useState, useEffect } from "react";
// import "./App.css";
// import BookingForm from "./BookingForm"; // Import the BookingForm component

// const App = () => {
//   const [clothes, setClothes] = useState([]);
//   const [searchQuery, setSearchQuery] = useState(""); // State for search query
//   const [filteredClothes, setFilteredClothes] = useState([]);
//   const [sortOrder, setSortOrder] = useState("asc"); // Default sort order: ascending
//   const [showBookingForm, setShowBookingForm] = useState(false); // Control the visibility of the booking form
//   const [selectedCloth, setSelectedCloth] = useState(null); // Store selected cloth for booking

//   useEffect(() => {
//     // Fetch clothes from your backend API
//     fetch("http://localhost:8081/api/clothes")
//       .then((response) => response.json())
//       .then((data) => {
//         setClothes(data);
//         setFilteredClothes(data); // Initially, display all clothes
//       })
//       .catch((error) => console.error("Error fetching clothes:", error));
//   }, []);

//   // Handle search input changes
//   const handleSearchChange = (event) => {
//     const query = event.target.value.toLowerCase();
//     setSearchQuery(query);

//     // Filter clothes based on the search query
//     const filtered = clothes.filter((cloth) =>
//       cloth.name.toLowerCase().includes(query)
//     );
//     setFilteredClothes(filtered);
//   };

//   // Handle sorting by price (Low to High or High to Low)
//   const handleSortChange = (event) => {
//     const selectedSortOrder = event.target.value;
//     setSortOrder(selectedSortOrder);

//     // Sort clothes based on the selected sort order
//     const sortedClothes = [...filteredClothes].sort((a, b) => {
//       if (selectedSortOrder === "asc") {
//         return a.rentPrice - b.rentPrice; // Low to High
//       } else if (selectedSortOrder === "desc") {
//         return b.rentPrice - a.rentPrice; // High to Low
//       }
//       return 0; // Default case
//     });

//     setFilteredClothes(sortedClothes); // Update the filtered clothes with sorted data
//   };

//   // Handle booking button click
//   const handleBookingClick = (cloth) => {
//     setSelectedCloth(cloth); // Set the selected cloth for booking
//     setShowBookingForm(true); // Show the booking form
//   };

//   return (
//     <div className="app-container container">
//       <h1>Event Attire Rental System</h1>
//       <div className="filters d-flex justify-content-center gap-3 mb-4 flex-wrap">
//         <select className="form-select" aria-label="Default select example">
//           <option>All Categories</option>
//           <option>Gown</option>
//           <option>Saree</option>
//           <option>Shrewani</option>
//         </select>
//         <input
//           type="text"
//           placeholder="Search for Clothes"
//           className="form-control"
//           value={searchQuery}
//           onChange={handleSearchChange} // Bind input change to handler
//         />
//         <select
//           className="form-select"
//           onChange={handleSortChange}
//           value={sortOrder}
//         >
//           <option value="asc">Sort by Price: Low to High</option>
//           <option value="desc">Sort by Price: High to Low</option>
//         </select>
//       </div>

//       <div className="clothes-grid d-flex justify-content-center gap-4">
//         {filteredClothes.map((cloth) => (
//           <div key={cloth.id} className="cloth-card">
//             <img
//               src={cloth.imageUrl }
//               alt={cloth.name}
//               className="img-fluid rounded mb-3"
//             />
//             <h3>{cloth.name}</h3>
//             <p>{cloth.description}</p>
//             <p>
//               <strong>Rent Price: ₹</strong> {cloth.rentPrice}
//             </p>
//             <button
//               className="btn btn-primary"
//               onClick={() => handleBookingClick(cloth)}
//             >
//               Book This Cloth
//             </button>
//           </div>
//         ))}
//       </div>

//       {showBookingForm && selectedCloth && (
//         <BookingForm
//           cloth={selectedCloth}
//           onClose={() => setShowBookingForm(false)} // Close form
//         />
//       )}
//     </div>
//   );
// };

// export default App;







import React, { useState, useEffect } from "react";
import "./App.css";
import BookingForm from "./BookingForm"; // Import the BookingForm component

const App = () => {
  const [clothes, setClothes] = useState([]);
  const [searchQuery, setSearchQuery] = useState(""); // State for search query
  const [filteredClothes, setFilteredClothes] = useState([]);
  const [sortOrder, setSortOrder] = useState("asc"); // Default sort order: ascending
  const [showBookingForm, setShowBookingForm] = useState(false); // Control the visibility of the booking form
  const [selectedCloth, setSelectedCloth] = useState(null); // Store selected cloth for booking
  const [selectedGender, setSelectedGender] = useState(""); // State for selected gender

  useEffect(() => {
    // Fetch clothes from your backend API
    fetch("http://localhost:8081/api/clothes")
      .then((response) => response.json())
      .then((data) => {
        setClothes(data);
        setFilteredClothes(data); // Initially, display all clothes
      })
      .catch((error) => console.error("Error fetching clothes:", error));
  }, []);

  // Handle search input changes
  const handleSearchChange = (event) => {
    const query = event.target.value.toLowerCase();
    setSearchQuery(query);

    // Filter clothes based on the search query
    const filtered = clothes.filter((cloth) =>
      cloth.name.toLowerCase().includes(query)
    );
    setFilteredClothes(filtered);
  };

  // Handle sorting by price (Low to High or High to Low)
  const handleSortChange = (event) => {
    const selectedSortOrder = event.target.value;
    setSortOrder(selectedSortOrder);

    // Sort clothes based on the selected sort order
    const sortedClothes = [...filteredClothes].sort((a, b) => {
      if (selectedSortOrder === "asc") {
        return a.rentPrice - b.rentPrice; // Low to High
      } else if (selectedSortOrder === "desc") {
        return b.rentPrice - a.rentPrice; // High to Low
      }
      return 0; // Default case
    });

    setFilteredClothes(sortedClothes); // Update the filtered clothes with sorted data
  };

  // Handle gender selection change
  const handleGenderChange = (event) => {
    const gender = event.target.value;
    setSelectedGender(gender);

    // Filter clothes based on selected gender
    const filtered = clothes.filter((cloth) =>
      gender ? cloth.gender === gender : true
    );
    setFilteredClothes(filtered);
  };

  // Handle booking button click
  const handleBookingClick = (cloth) => {
    setSelectedCloth(cloth); // Set the selected cloth for booking
    setShowBookingForm(true); // Show the booking form
  };

  return (
    <div className="app-container container">
      <h1>Event Attire Rental System</h1>
      <div className="filters d-flex justify-content-center gap-3 mb-4 flex-wrap">
        {/* Gender Dropdown */}
        <select
          className="form-select"
          aria-label="Select Gender"
          onChange={handleGenderChange}
          value={selectedGender}
        >
          <option value="">Select Gender</option>
          <option value="Male">Male</option>
          <option value="Female">Female</option>
        </select>

        <input
          type="text"
          placeholder="Search for Clothes"
          className="form-control"
          value={searchQuery}
          onChange={handleSearchChange} // Bind input change to handler
        />
        <select
          className="form-select"
          onChange={handleSortChange}
          value={sortOrder}
        >
          <option value="asc">Sort by Price: Low to High</option>
          <option value="desc">Sort by Price: High to Low</option>
        </select>
      </div>

      <div className="clothes-grid d-flex justify-content-center gap-4">
        {filteredClothes.map((cloth) => (
          <div key={cloth.id} className="cloth-card">
            <img
              src={cloth.imageUrl}
              alt={cloth.name}
              className="img-fluid rounded mb-3"
            />
            <h3>{cloth.name}</h3>
            <p>{cloth.description}</p>
            <p>
              <strong>Rent Price: ₹</strong> {cloth.rentPrice}
            </p>
            <button
              className="btn btn-primary"
              onClick={() => handleBookingClick(cloth)}
            >
              Book This Cloth
            </button>
          </div>
        ))}
      </div>

      {showBookingForm && selectedCloth && (
        <BookingForm
          cloth={selectedCloth}
          onClose={() => setShowBookingForm(false)} // Close form
        />
      )}
    </div>
  );
};

export default App;
