export const consultantsTopics = ["Development","Everyday Deloitte", "Human Capital", "Strategy & Operations", "Technology"];
export const development = ["Oracle practice","SAP practice","Other"];
export const strategyAndOperations = ["Finance","Mergers & Acquisitions", "Operations","Strategy","Supply Chain","Other"];
export const everydayDeloitte = ["As a Junior","As an Intern","As a Manager","Other query","Other"];
export const humanCapital = ["HR transformation","Leadership","People analytics","Strategic change and organisation transformation","Talent","Other"];
export const technology = ["Analytics and information management","Systems integration","Technology architecture and strategy","Other"];
//not currently used, but would be used in refactoring the subtopiclists
export const employeeConvoTopics = {
    [consultantsTopics[0]]: development,
    [consultantsTopics[1]]: everydayDeloitte,
    [consultantsTopics[2]]: humanCapital,
    [consultantsTopics[3]]: strategyAndOperations,
    [consultantsTopics[4]]: technology
}