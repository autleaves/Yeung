select dept_name, count(distinct instructor.ID) as instr_count
from instructor, teaches
where instructor.ID = teaches.ID and
	semester='Spring' and year = 2018
group by dept_name;