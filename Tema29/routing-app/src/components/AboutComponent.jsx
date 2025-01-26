import { useSearchParams } from "react-router";

const AboutComponent = (props) => {

    const [searchParams, setSearchParams] = useSearchParams();

    console.log(searchParams.size);


    return (
        <>
            <h1>{props.message}</h1>
            {
                searchParams.size > 0 &&
                <div>
                    You searched for:
                    {
                        Array.from(searchParams.keys()).map(key => 
                            <div key={key}>
                                {`${key} --> ${searchParams.get(key)}`}
                            </div>
                        )
                    }
                    <h3>Contact: mailme@devmind.ro</h3>
                </div>
                
            }
        </>
    )
}

export default AboutComponent;