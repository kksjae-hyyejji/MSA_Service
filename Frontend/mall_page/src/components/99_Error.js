const Error = (props) => {
    return (
        <div>
            <h1>{props.status == null ? "404 Not Found" : props.status}</h1>
            <br />
            <p>{props.message == null ? "에러가 발생했습니다." : props.message}</p>
        </div>
    );
}

export default Error;