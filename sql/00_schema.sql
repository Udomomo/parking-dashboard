CREATE TABLE admin_accounts (
    id UUID PRIMARY KEY,
    email VARCHAR(128) NOT NULL,
    password VARCHAR(256) NOT NULL,
    status VARCHAR(16) NOT NULL
);

CREATE TABLE admins (
    id UUID PRIMARY KEY,
    admin_account_id UUID NOT NULL REFERENCES admin_accounts (id),
    name VARCHAR(64) NOT NULL,
    code VARCHAR(32) NOT NULL
);

CREATE TABLE customers (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    address VARCHAR(256) NOT NULL,
    phone_number VARCHAR(32) NOT NULL
);

CREATE TABLE contracts (
    id UUID PRIMARY KEY,
    customer_id UUID NOT NULL REFERENCES customers(id),
    start_at DATE NOT NULL,
    end_at DATE
);

CREATE TABLE contract_create_events (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL REFERENCES contracts(id),
    contract_start_at DATE NOT NULL,
    event_date DATE NOT NULL
);

CREATE TABLE contract_cancell_events (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL REFERENCES contracts(id),
    contract_end_at DATE NOT NULL,
    event_date DATE NOT NULL
);

CREATE TABLE parks (
    id UUID PRIMARY KEY,
    name VARCHAR(64) NOT NULL,
    address VARCHAR(128) NOT NULL
);

CREATE TABLE districts (
    id UUID PRIMARY KEY,
    park_id UUID NOT NULL references parks(id),
    name VARCHAR(64) NOT NULL,
    number INTEGER NOT NULL
);

CREATE TABLE cars (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL REFERENCES contracts(id),
    number INTEGER NOT NULL,
    type_number INTEGER NOT NULL
);

CREATE TABLE contract_car_events (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL REFERENCES contracts(id),
    event_type VARCHAR(16) NOT NULL,
    car_id UUID NOT NULL REFERENCES cars(id),
    event_date DATE NOT NULL
);

CREATE TABLE contract_district_events (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL REFERENCES contracts(id),
    event_type VARCHAR(16) NOT NULL,
    district_id UUID NOT NULL REFERENCES districts(id),
    event_date DATE NOT NULL
);

CREATE TABLE contract_assignee_mappings (
    contract_id UUID NOT NULL REFERENCES contracts(id),
    admin_account_id UUID NOT NULL REFERENCES admin_accounts(id),
    PRIMARY KEY (contract_id, admin_account_id)
);

CREATE TABLE contract_district_mappings (
    district_id UUID NOT NULL REFERENCES districts(id),
    contract_id UUID NOT NULL REFERENCES contracts(id),
    PRIMARY KEY (district_id, contract_id)
);

CREATE TABLE billings (
    id UUID PRIMARY KEY,
    contract_id UUID NOT NULL REFERENCES contracts(id),
    price INTEGER NOT NULL,
    period_start_at DATE NOT NULL,
    period_end_at DATE NOT NULL,
    due_date DATE NOT NULL,
    status VARCHAR(16) NOT NULL
);

CREATE TABLE billing_payment_events (
    billing_id UUID NOT NULL REFERENCES billings(id),
    event_date DATE NOT NULL
);

CREATE TABLE billing_revert_events (
   billing_id UUID NOT NULL REFERENCES billings(id),
   event_date DATE NOT NULL
);
