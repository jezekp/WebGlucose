package cz.zcu.kiv.glucose.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.io.Serializable;

/***********************************************************************************************************************
 * This file is part of the glucose project
 * <p>
 * ==========================================
 * <p>
 * Copyright (C) 2015 by University of West Bohemia (http://www.zcu.cz/en/)
 * <p>
 * **********************************************************************************************************************
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * <p>
 * **********************************************************************************************************************
 * <p>
 * GenericDao, 2015/09/17 09:53 petr-jezek
 **********************************************************************************************************************/
public interface GenericDao <T, PK extends Serializable>  {

    /** Persist the newInstance object into database */
    PK create(T newInstance);

    /** Retrieve an object that was previously persisted to the database using
     *   the indicated id as primary key
     */
    T read(PK id);

    /** Save changes made to a persistent object.  */
    void update(T transientObject);

    /** Remove an object from persistent storage in the database */
    void delete(T persistentObject);
}
