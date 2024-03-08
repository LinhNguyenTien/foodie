import "../../css/mngtTableHome.css";


//
import { DataGrid } from '@mui/x-data-grid';

//data
import { staffMngtColumns, allStaffMngtRows } from "../../data/dataStaffMngtHome";


import { Link } from "react-router-dom";
import { useState } from "react";



const AllTableStaffMngt = () => {

    const [data, setData] = useState(allStaffMngtRows);

    const handleDelete = (id) => {
        setData(data.filter((item) => item.id !== id));
    };

    const actionColumn = [

        {
            field: "action",
            headerName: "",
            width: 250,
            renderCell: (params) => {
                return (
                    <div className="cellAction">
                        <Link to="/staffManagement/test" style={{ textDecoration: "none" }}>
                            <div className="viewButton">Xem chi tiết</div>
                        </Link>

                        {/* if status:Hoạt động => button: Khóa (Khóa => Mở khóa) */}
                        <div
                            className="blockButton"
                        //onClick={() => handleBlock(params.row.id)}
                        >
                            Khóa
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
                columns={staffMngtColumns.concat(actionColumn)}

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

export default AllTableStaffMngt 