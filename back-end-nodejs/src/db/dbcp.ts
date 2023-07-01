import mysql, {Pool} from 'promise-mysql';
import env from 'dotenv';

env.config();
export let pool: Pool;

(async function () {
    pool = await mysql.createPool({
        host: process.env.DB_HOST,
        port: +process.env.DB_PORT!,
        user: process.env.DB_USER,
        password: process.env.DB_PASSWORD,
        database: process.env.DB_NAME,
        connectionLimit: +process.env.DB_CP_SIZE!
    });
})();