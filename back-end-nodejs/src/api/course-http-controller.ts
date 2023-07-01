import express from 'express';
import {pool} from "../db/dbcp";

export const router = express.Router();

type Course = {
    "id": string,
    "description": string,
    "duration": number
}

router.get('/', async (req, res)=>{
    const courses = await pool.query("SELECT * FROM course");
    res.json(courses);
});

