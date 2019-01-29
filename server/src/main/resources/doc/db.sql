CREATE TABLE public.accesscontrollist (
	uidwhere uuid NULL,
	uidwho varchar NULL
)
CREATE TABLE public.assignee (
	uid varchar NULL,
	"name" varchar NULL,
	login varchar NULL,
	pass int4 NULL,
	grp varchar NULL,
	isadmin bool NULL
)
CREATE TABLE public.project (
	uid varchar NULL,
	"name" varchar NULL,
	ownerid varchar NULL
)
CREATE TABLE public.projectassignee (
	assigneeid varchar NULL,
	projectid varchar NULL
)
CREATE TABLE public.projecttask (
	projectid varchar NULL,
	taskid varchar NULL,
	CONSTRAINT uniquepair UNIQUE (projectid, taskid)
)
CREATE TABLE public."session" (
	sessionid varchar NULL,
	userid varchar NULL,
	"timestamp" varchar NULL
)
CREATE TABLE public.task (
	uid varchar NULL,
	"name" varchar NULL,
	hours int2 NULL,
	state varchar NULL,
	priority varchar NULL,
	ownerid varchar NULL
)
CREATE TABLE public.taskassignee (
	taskid varchar NULL,
	assigneeid varchar NULL
)
