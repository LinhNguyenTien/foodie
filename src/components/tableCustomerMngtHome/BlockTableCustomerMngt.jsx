import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { customerMngtColumns, blockCustomerMngtRows } from "../../data/dataCustomerMngtHome";


import { Link } from "react-router-dom";
import { useState } from "react";


const BlockTableCustomerMngt = () => {

    const [data, setData] = useState(blockCustomerMngtRows);

    const handleUnlock = (id) => {
        setData(data.filter((item) => item.id !== id));
    };

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
                        <div
                            className="activeButton"
                            onClick={() => handleUnlock(params.row.id)}
                        >
                            Mở khóa
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

export default BlockTableCustomerMngt