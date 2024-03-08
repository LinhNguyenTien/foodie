import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { customerMngtColumns, allCustomerMngtRows } from "../../data/dataCustomerMngtHome";


import { Link } from "react-router-dom";
import { useState } from "react";


const AllTableCustomerMngt = () => {

    const [data] = useState(allCustomerMngtRows);
    //const [data, setData] = useState(allCustomerMngtRows);

    const actionColumn = [
        {
            field: "action",
            headerName: "",
            width: 180,
            renderCell: (params) => {
                return (
                    <div className="cellAction">
                        <Link to="/customerManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>

                        {/* if status:Hoạt động => button: Khóa (Khóa => Mở khóa) */}
                        <div
                            className="blockButton"
                        //onClick={() => handleBlock(params.row.id)}
                        >
                            Khóa
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
                columns={customerMngtColumns.concat(actionColumn)}
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

export default AllTableCustomerMngt