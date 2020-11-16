import React, { useEffect } from "react";
import { useForm } from "react-hook-form";
import axios from "axios";
import { Badge, Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import Moment from "moment";

const Home = () => {
  const [registrationList, setRegistrationList] = React.useState([]);
  const [detailedList, setDetailedList] = React.useState([]);

  const [regoSelected, setRegoSelected] = React.useState("");
  const [isFullList, setIsFullList] = React.useState(false);
  const [errorInAPICall, setErrorInAPICall] = React.useState(false);
  const [errorMessageAPI, setErrorMessageAPI] = React.useState("");
  const { register, handleSubmit, errors } = useForm();

  useEffect(() => {
    axios
      .get("http://localhost:8088//vehicle/registrations/1/details")
      .then(function (response) {
        setRegistrationList(response.data.registrations);
      })
      .catch(function (error) {
        setErrorInAPICall(true);
        if (!error.status){
          console.log("error response" + error.status);
          setErrorMessageAPI("The site is encountering a temporary network issue!");
        } else {
          setErrorMessageAPI(error.response.data);
        }
      });
  }, [isFullList]);

  const handleRegoClick = (data) => {
    setRegoSelected(data);
    setIsFullList(true);
    console.log("detailed show enabled" + isFullList);

    console.log("clicked rego data" + data);
    console.log("clicked rego data" + registrationList);

    let filteredList = registrationList.filter((list) =>
      list.plateNumber.includes(data)
    );

    setDetailedList(filteredList);

    console.log("clicked rego data" + JSON.stringify(filteredList));
  };

  return (
    <React.Fragment>
      <div
        className="col-12 col-lg-12 ml-12 mt-12"
        style={{
          backgroundColor: "#58b2ca4d",

          minHeight: "200px",
        }}
      >
        <h2>Registered cars:</h2>

       

    
        <Table striped bordered hover variant="light">
          <thead>
            <tr>
              <th>Rego number</th>
              <th>Car details</th>
              <th>Expiry/status</th>
            </tr>
          </thead>
          <tbody>
            {registrationList.map((home) => (
              <tr>
                <td
                  value={home.plateNumber}
                  onClick={() => handleRegoClick(home.plateNumber)}
                >
                  <Link>{home.plateNumber}</Link>
                </td>
                <td>{home.vehicle.type}</td>

                <td>
                  {Moment(home.registration.expiry_date).format("YYYY-MM-DD")}
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
   
        {errorInAPICall && (
          <div>
              <h3>{errorMessageAPI}</h3>
          </div>
        )}

        {isFullList && (
          <div>
            <h2>Detailed registration cars:</h2>

            <Table striped bordered hover variant="light">
              <thead>
                <tr>
                  <th>Rego number</th>
                  <th>Car details</th>
                  <th>Expiry/status</th>
                  <th>make</th>
                  <th>model</th>
                  <th>colour</th>
                  <th>vin</th>
                  <th>tare_weight</th>
                  <th>gross_mass</th>
                </tr>
              </thead>
              <tbody>
                {detailedList.map((home) => (
                  <tr>
                    <td
                      value={home.plateNumber}
                      onClick={() => handleRegoClick(home.plateNumber)}
                    >
                      {home.plateNumber}
                    </td>
                    <td>{home.vehicle.type}</td>
                    <td>
                      {Moment(home.registration.expiry_date).format(
                        "YYYY-MM-DD"
                      )}
                    </td>
                    <td>{home.vehicle.make}</td>
                    <td>{home.vehicle.model}</td>
                    <td>{home.vehicle.colour}</td>
                    <td>
                      {home.vehicle.vin
                        .toString()
                        .slice(home.vehicle.vin.toString().length - 4)}
                    </td>
                    <td>{home.vehicle.tare_weight}</td>
                    <td>{home.vehicle.gross_mass}</td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </div>
        )}




      
      </div>
    </React.Fragment>
  );
};

export default Home;
