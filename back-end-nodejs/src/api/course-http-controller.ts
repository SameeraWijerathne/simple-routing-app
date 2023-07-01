import express from 'express';
import {pool} from "../db/dbcp";

export const router = express.Router();

type Course = {
    "id": string,
    "description": string,
    "duration": number
}
/* get All Courses */
router.get('/', async (req, res)=>{
    const courses = await pool.query("SELECT * FROM course");
    res.json(courses);
});

/* save a course */
router.post('/', async (req, res)=>{
    const course = (req.body as Course);
    if (!course.id?.trim() || !course.description?.trim() || +course.duration < 0 || !course.duration) {
        res.sendStatus(400);
        return;
    }
    const result = await pool.query("INSERT INTO course (id, description, duration) VALUES (?,?,?)",
        [course.id, course.description, course.duration]);
    res.status(201).json(course);
});

/* delete a course */
router.delete('/:courseId', async (req, res)=>{
    const result = await pool.query("DELETE FROM course WHERE id=?", [req.params.courseId]);
    res.sendStatus(result.affectedRows ? 204 : 404);
});