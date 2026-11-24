import {test, expect} from '@playwright/test';

test('completes an order successfully', async ({page}) => {
    await page.goto('https://www.saucedemo.com');
    await expect(page.locator('.login_logo')).toHaveText('Swag Labs');
    await page.getByPlaceholder('Username').fill('standard_user');
    await page.getByPlaceholder('Password').fill('secret_sauce');
    await page.getByTestId('login-button').click();
    await expect(page.getByTestId('title')).toHaveText('Products');

    await page.getByTestId('add-to-cart-sauce-labs-backpack').click();
    await page.getByTestId('shopping-cart-link').click();
    await expect(page.getByTestId('title')).toHaveText('Your Cart');

    await expect(page.getByTestId('inventory-item-name')).toHaveText('Sauce Labs Backpack');
    await page.getByRole('button', { name: 'Checkout' }).click();

    await expect(page.getByText('Checkout: Your Information')).toBeVisible();
    await page.getByPlaceholder('First Name').fill('John');
    await page.getByPlaceholder('Last Name').fill('Doe');
    await page.getByPlaceholder('Zip/Postal Code').fill('12345');
    await page.getByRole('button', { name: 'Continue' }).click();
    await expect(page.getByText('Checkout: Overview')).toBeVisible();

    await expect(page.getByTestId('inventory-item-name')).toHaveText('Sauce Labs Backpack');
    await expect.soft(page.getByTestId('subtotal-label')).toHaveText('Item total: $29.99');
    await expect.soft(page.getByTestId('tax-label')).toHaveText('Tax: $2.40');
    await expect(page.getByTestId('total-label')).toHaveText('Total: $32.39');
    await page.getByRole('button', { name: 'Finish' }).click();
    await expect(page.getByText('Checkout: Complete!')).toBeVisible();
    await expect(page.getByTestId('complete-header')).toHaveText(/Thank you for your order!/);
});