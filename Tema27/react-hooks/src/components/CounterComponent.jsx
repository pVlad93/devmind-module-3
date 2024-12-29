import React from "react";
import { useState, useEffect } from "react";

const CounterComponent = (props) => {

    const [incrementCounter, setIncrementCounter] = useState(0);
    const [decrementCounter, setDecrementCounter] = useState(0);

    useEffect(() => {
        console.log('Mounting incrementCounter: {}', incrementCounter);
        console.log('Mounting decrementCounter: {}', decrementCounter);
        return () => {
            console.log('will unmount incrementCounter: {}', incrementCounter);
            console.log('will unmount decrementCounter: {}', decrementCounter);
        }
    }, [incrementCounter, decrementCounter]);

    return(
        <>
            <div>
                <h1>Increment counter</h1>
                <h2>{`Increment counter value: ${incrementCounter}`}</h2>
                <button onClick={() => setIncrementCounter(incrementCounter + 1)}>Click me to increment</button>
            </div>
            <div>
                <h1>Decrement counter</h1>
                <h2>{`Decrement counter value: ${decrementCounter}`}</h2>
                <button onClick={() => setDecrementCounter(decrementCounter - 1)}>Click me to increment</button>
            </div>
        </>
    );
}

export default CounterComponent;