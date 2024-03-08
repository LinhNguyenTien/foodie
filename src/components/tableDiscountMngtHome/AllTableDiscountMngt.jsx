import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { discountMngtColumns, allDiscountMngtRows } from "../../data/dataDiscountMngtHome ";


import { Link } from "react-router-dom";
import { useState } from "react";



const AllTableDiscountMngt = () => {

    const [data, setData] = useState(allDiscountMngtRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };
    // const handleBlock = (id) => {

    // };
    const actionColumn = [
        {
            field: "action",
            headerName: "",
            width: 250,
            renderCell: (params) => {
                return (
                    <div className="cellAction">
                        <Link to="/discountManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>

                        {/* if status:Hoạt động => button: Lưu kho (Lưu kho => Sử dụng) (Hết hạn: chỉ có btn Xem chi tiết + Xóa*/}
                        <div
                            className="blockButton"
                        //onClick={() => handleBlock(params.row.id)}
                        >
                            Lưu kho
                        </div>
                        <div
                            className="deleteButton"
                            onClick={() => handleDelete(params.row.id)}
                        >
                            Xóa
                        </div>
                    </div>
                );
            },
        },
    ];

    return (
        <div className="datatable" >
            <DataGrid className="datagrid"
                rows={data}
                columns={discountMngtColumns.concat(actionColumn)}

                initialState={{
                    pagination: {
                        paginationModel: { page: 0, pageSize: 9 },
                    },
                }}
                pageSizeOptions={[9]}
                checkboxSelection
            />
        </div>
    )
}

export default AllTableDiscountMngt