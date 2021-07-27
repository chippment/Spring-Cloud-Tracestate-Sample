#!/bin/bash

curl -X POST -H "Content-Type: application/json"  -H "traceparent: 00-8df82d9e560f4c318f2c3c1ce7d69a0a-8dc0d640e5c62ebe-01" -H "tracestate: sappp=CwAAmEnGj0gThK52TCXZ270X8nBhc3Nwb3J0LWFwcABQT1NU" localhost:8003/notify
