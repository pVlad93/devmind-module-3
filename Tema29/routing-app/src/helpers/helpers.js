export const tableHelper = (tableData) => {
    const result = [];
    for(let current of tableData) {
        const row = {
            id: current.id,
            name: current.name,
            ownerName: current.owner.login,
            repoDescription: current.description ? current.description : "",
            link: current.html_url,
            defaultBranch: current.default_branch
        };
        result.push(row);
    }
    return result;
}