
SELECT		distinct e.LastName, e.FirstName, min(years) as FirstContractAt, max(years) as LastContractAt, 20 as numberOfYearsServed,EmployeeResidanceDuringContract,EmployeeResidanceZipCode,EmployeeResidanceCity
FROM		(SELECT		* ,(Select Distinct extract(YEAR From ContractStartingTime)) As years
			 FROM		employees) e
GROUP BY	e.FirstName, e.LastName
having (count(Distinct years) = 20 and lastContractAt = 2013) or (count(Distinct years) = 21 and lastContractAt = 2014);


SELECT		distinct e.LastName, e.FirstName, min(years) as FirstContractAt, max(years) as LastContractAt, 25 as numberOfYearsServed,EmployeeResidanceDuringContract,EmployeeResidanceZipCode,EmployeeResidanceCity
FROM		(SELECT		* ,(Select Distinct extract(YEAR From ContractStartingTime)) As years
			 FROM		employees) e
GROUP BY	e.FirstName, e.LastName
having (count(Distinct years) = 25 and lastContractAt = 2013) or (count(Distinct years) = 26 and lastContractAt = 2014);


SELECT		distinct e.LastName, e.FirstName, min(years) as FirstContractAt, max(years) as LastContractAt, 30 as numberOfYearsServed,EmployeeResidanceDuringContract,EmployeeResidanceZipCode,EmployeeResidanceCity
FROM		(SELECT		* ,(Select Distinct extract(YEAR From ContractStartingTime)) As years
			 FROM		employees) e
GROUP BY	e.FirstName, e.LastName
having (count(Distinct years) = 30 and lastContractAt = 2013) or (count(Distinct years) = 31 and lastContractAt = 2014);


SELECT		distinct e.LastName, e.FirstName, min(years) as FirstContractAt, max(years) as LastContractAt, 35 as numberOfYearsServed,EmployeeResidanceDuringContract,EmployeeResidanceZipCode,EmployeeResidanceCity
FROM		(SELECT		* ,(Select Distinct extract(YEAR From ContractStartingTime)) As years
			 FROM		employees) e
GROUP BY	e.FirstName, e.LastName
having (count(Distinct years) = 35 and lastContractAt = 2013) or (count(Distinct years) = 36 and lastContractAt = 2014);


SELECT		distinct e.LastName, e.FirstName, min(years) as FirstContractAt, max(years) as LastContractAt, 40 as numberOfYearsServed,EmployeeResidanceDuringContract,EmployeeResidanceZipCode,EmployeeResidanceCity
FROM		(SELECT		* ,(Select Distinct extract(YEAR From ContractStartingTime)) As years
			 FROM		employees) e
GROUP BY	e.FirstName, e.LastName
having (count(Distinct years) = 40 and lastContractAt = 2013) or (count(Distinct years) = 41 and lastContractAt = 2014);