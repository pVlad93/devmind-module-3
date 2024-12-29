import React from "react";
import { useState, useEffect } from "react";

const Stopwatch = () => {
    const [time, setTime] = useState(0);
    const [isRunning, setIsRunning] = useState(false);
  
    useEffect(() => {
      let intervalId;
      if (isRunning) {
        intervalId = setInterval(() => setTime(time + 1), 10);
      }
      return () => clearInterval(intervalId);
    }, [isRunning, time]);
  
    const minutes = Math.floor((time % 360000) / 6000);
  
    const seconds = Math.floor((time % 6000) / 100);
  
    const start = () => {
        if(!isRunning) {
            setIsRunning(true);
        }
    };

    const stop = () => {
        if(isRunning) {
            setIsRunning(false);
        }
    };

    return (
      <div>
        <p>
          Minutes: {minutes}
        </p>
        <p>
          Seconds: {seconds}
        </p>
          <button onClick={start}>
            Start
          </button>
          <button onClick={stop}>
            Stop
          </button>
      </div>
    );
  };

export default Stopwatch;