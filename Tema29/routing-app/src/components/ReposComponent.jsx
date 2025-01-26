import "./table.css";
import { tableHelper } from "../helpers/helpers";

const ReposComponent = (props) => {
    const tableData = tableHelper(props.info);
    return (
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Repo name</th>
                    <th>Owner name</th>
                    <th>Repo link</th>
                    <th>Repo description</th>
                    <th>Default branch</th>
                </tr>
            </thead>
            <tbody>
                {
                    tableData.map((row) => (
                        <tr key={row.id}>
                            <td>{row.id}</td>
                            <td>{row.name}</td>
                            <td>{row.ownerName}</td>
                            <td>{row.repoDescription}</td>
                            <td><a href={row.link} target="_blank">{row.link}</a></td>
                            <td>{row.defaultBranch}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    )
}

export default ReposComponent;
