import {test, expect} from '@playwright/test';

test('adds and removes a product from the cart', async ({page}) => {
    await page.goto('https://www.saucedemo.com');
    await expect(page.locator('.login_logo')).toHaveText('Swag Labs');
    await page.getByPlaceholder('Username').fill('standard_user');
    await page.getByPlaceholder('Password').fill('secret_sauce');
    await page.getByTestId('login-button').click();
    await expect(page.getByTestId('title')).toHaveText('Products');
    await page.getByTestId('add-to-cart-sauce-labs-backpack').click();
    await expect(page.getByTestId('remove-sauce-labs-backpack')).toBeVisible();
    await expect(page.getByTestId('shopping-cart-badge')).toHaveText('1');
    await page.getByTestId('remove-sauce-labs-backpack').click();
    await expect(page.getByTestId('add-to-cart-sauce-labs-backpack')).toBeVisible();
    await expect(page.getByTestId('shopping-cart-badge')).toBeHidden();
});