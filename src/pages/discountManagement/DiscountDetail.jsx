import "../../css/mngtDetail.css";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
// import Chart from "../../../components/chart/Chart";

import { Link } from "react-router-dom";
import { discountInputs } from "../../data/dataFormDiscountMngt";
import { useState } from "react";


const DiscountDetail = () => {
    const [inputs] = useState(discountInputs);
    return (
        <div className="single">
            <Sidebar />
            <div className="singleContainer">
                <Navbar />
                <div className="top">
                    <div className="left">
                        <Link to="/discountManagement/editDiscount" style={{ textDecoration: "none" }}>
                            <div className="editButton">Chỉnh sửa</div>
                        </Link>

                        <h1 className="title">Thông tin khuyến mãi</h1>
                        <div className="item">

                            <div className="details">
                                {inputs.map((input) => (
                                    <div className="detailItem" key={input.id}>
                                        <span className="itemKey">{input.label}:</span>
                                        <span className="itemValue">{input.value}</span>
                                    </div>
                                ))}
                            </div>

                        </div>
                    </div>
                    {/* <div className="right">
                        <Chart aspect={3 / 1} title="User Spending ( Last 6 Months)" />
                    </div> */}
                </div>
                <div className="bottom">
                    <h1 className="title">Đơn hàng đã áp dụng khuyến mãi</h1>

                </div>
            </div>
        </div>
    );
};

export default DiscountDetail;
