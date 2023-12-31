import express, {json} from 'express';
import {router as CourseRouter} from "./api/course-http-controller";
import cors from 'cors';

const app = express();

app.use(cors());
app.use(json());
app.use("/app/api/v1/courses", CourseRouter);
app.listen(8081, () => console.log("Server has been started at 8081"));
